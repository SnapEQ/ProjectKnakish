package com.team1.projectknakish.config;

import com.team1.projectknakish.domain.entities.Department;
import com.team1.projectknakish.domain.entities.dict.*;
import com.team1.projectknakish.domain.entities.tasks.BudgetClassificationNode;
import com.team1.projectknakish.domain.entities.tasks.ClassificationLevel;
import com.team1.projectknakish.repositories.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class DevRefrenceDataSeeder implements CommandLineRunner {
    private final BudgetItemRepository budgetItemRepository;
    private final ParagraphRepository paragraphRepository;
    private final BudgetClassificationNodeRepository budgetClassificationNodeRepository;
    private final SubSectionRepository subSectionRepository;
    private final BudgetPartRepository budgetPartRepository;
    private final SectionRepository sectionRepository;
    private final FinanceSourceRepository financeSourceRepository;
    private final ExpenseGroupRepository expenseGroupRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public void run(String... args) {
        clearDatabase();

        loadBudgetPart();
        loadSection();
        loadSubSection();
        loadFinanceSource();
        loadExpenseGroups();
        loadParagraphs();
        loadBudgetClassificationNodes();
        loadDepartments();
    }


    private void clearDatabase() {
        budgetItemRepository.deleteAll();
        paragraphRepository.deleteAll();
        budgetClassificationNodeRepository.deleteAll();
        subSectionRepository.deleteAll();
        budgetPartRepository.deleteAll();
        sectionRepository.deleteAll();
        financeSourceRepository.deleteAll();
        expenseGroupRepository.deleteAll();
        departmentRepository.deleteAll();
    }

    private List<CSVRecord> readCsv(String fileName) {
        try {
            ClassPathResource resource =
                    new ClassPathResource("refrence-data/" + fileName);

            try (Reader reader = new InputStreamReader(
                    resource.getInputStream(),
                    StandardCharsets.UTF_8
            )) {
                return CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .setTrim(true)
                        .build()
                        .parse(reader)
                        .getRecords();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read CSV: " + fileName, e);
        }
    }

    private String parentCode(String code) {
        int lastDot = code.lastIndexOf('.');

        return lastDot == -1 ? null : code.substring(0, lastDot);
    }

    private BudgetClassificationNode requireNode(
            Map<String, BudgetClassificationNode> nodesByCode,
            String code
    ) {
        BudgetClassificationNode node = nodesByCode.get(code);

        if (node == null) {
            throw new IllegalStateException(
                    "Missing classification parent with code: " + code
            );
        }

        return node;
    }

    private void loadNodes(
            String fileName,
            ClassificationLevel level,
            Map<String, BudgetClassificationNode> nodesByCode
    ) {
        for (CSVRecord row : readCsv(fileName)) {
            String code = row.get("code");
            String name = row.get("name");

            BudgetClassificationNode node = new BudgetClassificationNode();
            node.setCode(code);
            node.setName(name);
            node.setClassificationLevel(level);

            String parentCode = parentCode(code);

            if (parentCode != null) {
                node.setParent(requireNode(nodesByCode, parentCode));
            }

            BudgetClassificationNode saved =
                    budgetClassificationNodeRepository.save(node);

            nodesByCode.put(saved.getCode(), saved);
        }
    }

   private void loadBudgetPart() {
        List<BudgetPart> parts = readCsv("budget_parts.csv").stream()
                .map(row -> {
                    BudgetPart part = new BudgetPart();
                    part.setCode(row.get("code"));
                    part.setName(row.get("name"));
                    return part;
                })
                .toList();

        budgetPartRepository.saveAll(parts);
   }

   private void loadSection() {
        List<Section> sections = readCsv("sections.csv").stream()
                .map(row -> {
                    Section section = new Section();
                    section.setCode(row.get("code"));
                    section.setName(row.get("name"));
                    return section;
                })
                .toList();

        sectionRepository.saveAll(sections);
   }

   private void loadSubSection() {
        List<SubSection> sections = readCsv("subsections.csv").stream()
                .map(row -> {
                    SubSection subSection = new SubSection();
                    subSection.setCode(row.get("code"));
                    subSection.setName(row.get("name"));
                    return subSection;
                })
                .toList();

        subSectionRepository.saveAll(sections);
   }


   private void loadFinanceSource() {
        List<FinanceSource> sources = readCsv("financing_sources.csv").stream()
                .map(row -> {
                    FinanceSource source = new FinanceSource();
                    source.setCode(row.get("code"));
                    source.setName(row.get("name"));
                    return source;
                })
                .toList();

        financeSourceRepository.saveAll(sources);
   }

    private void loadExpenseGroups() {
        List<ExpenseGroup> groups = readCsv("expense_groups.csv").stream()
                .map(row -> {
                    ExpenseGroup group = new ExpenseGroup();
                    group.setName(row.get("name"));
                    return group;
                })
                .toList();

        expenseGroupRepository.saveAll(groups);
    }

    private void loadParagraphs() {
        Map<String, ExpenseGroup> groupsByName = expenseGroupRepository.findAll()
                .stream()
                .collect(Collectors.toMap(
                        ExpenseGroup::getName,
                        Function.identity()
                ));

        List<Paragraph> paragraphs = readCsv("paragraphs.csv").stream()
                .map(row -> {
                    ExpenseGroup group = groupsByName.get(
                            row.get("expense_group")
                    );

                    if (group == null) {
                        throw new IllegalStateException(
                                "Unknown expense group: " + row.get("expense_group")
                        );
                    }

                    Paragraph paragraph = new Paragraph();
                    paragraph.setCode(row.get("code"));
                    paragraph.setName(row.get("name"));
                    paragraph.setExpenseGroup(group);

                    return paragraph;
                })
                .toList();

        paragraphRepository.saveAll(paragraphs);
    }

    private void loadBudgetClassificationNodes() {
        Map<String, BudgetClassificationNode> nodesByCode = new HashMap<>();

        loadNodes("functions.csv", ClassificationLevel.FUNCTION, nodesByCode);
        loadNodes("tasks.csv", ClassificationLevel.TASK, nodesByCode);
        loadNodes("subtasks.csv", ClassificationLevel.SUBTASK, nodesByCode);
        loadNodes("actions.csv", ClassificationLevel.ACTIVITY, nodesByCode);
    }

    private void loadDepartments() {
        List<Department> departments = readCsv("departments.csv").stream()
                .map(row -> {
                    Department department = new Department();
                    department.setName(row.get("name"));
                    return department;
                })
                .toList();

        departmentRepository.saveAll(departments);
    }
}
