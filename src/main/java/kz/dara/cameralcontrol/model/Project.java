package kz.dara.cameralcontrol.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "projects")
@Data
public class Project {
    @Id
    @Column(name = "project_id")
    @SequenceGenerator(name = "userGenerator", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "userGenerator", strategy = GenerationType.SEQUENCE)
    public Long Id;

    @Column(name = "status")
    public String status;

    @Column(name = "name")
    public String name;

    @Column(name = "acronym")
    public String acronym;

    @Column(name = "description")
    public String description;

//    @Column(name = "period")
//    public daterange period;

    @Column(name = "contact_email")
    public String contactEmail;

    @Column(name = "contact_name")
    public String contactName;

    @Column(name = "total_budget")
    public Long totalBudget;
    @Column(name = "total_funding")
    public Long totalFunding;
    @Column(name = "total_budget_for_eun")
    public Long totalBudgetForEun;
    @Column(name = "total_funding_for_eun")
    public Long totalFundingForEun;
    @Column(name = "funding_value")
    public Long fundingValue;
    @Column(name = "percentage_of_funding")
    public Long percentageOfFunding;
    @Column(name = "percentage_of_indirect_costs")
    public Long percentageOfIndirectCosts;
    @Column(name = "percentage_of_funding_for_eun")
    public Long percentageOfFundingForEun;
    @Column(name = "percentage_of_indirect_costs_for_eun")
    public Long percentageOfIndirectCostsForEun;
    @Column(name = "funding_extra_comment")
    public String fundingExtraComment;
    @Column(name = "programme")
    public String programme;
    @Column(name = "eu_dg")
    public String euDg;
    @Column(name = "role_of_eun")
    public String roleOfEun;
    @Column(name = "summary")
    public String summary;
    @Column(name = "main_tasks")
    public String mainTasks;
    @Column(name = "expected_outcomes")
    public String expectedOutcomes;
    @Column(name = "eu_call_reference")
    public String euCallReference;
    @Column(name = "eu_project_reference")
    public String euProjectReference;
    @Column(name = "eu_call_deadline")
    public String euCallDeadline;
    @Column(name = "project_manager")
    public String erojectManager;
    @Column(name = "reference_number_of_project")
    public Integer referenceNumberOfProject;
    @Column(name = "eun_team")
    public String eunTeam;
    @Column(name = "funding_id")
    public Long fundingId;
//    @Column(name = "sys_creat_timestamp")
//    public java.sql.Timestamp sysCreatTimestamp;
//    @Column(name = "sys_creat_ip_address")
//    public org.postgresql.util.PGobject sysCreatIpAddress;
//    @Column(name = "sys_modif_timestamp")
//    public java.sql.Timestamp sysModifTimestamp;
//    @Column(name = "sys_modif_ip_address")
//    public org.postgresql.util.PGobject sysModifIpAddress;
}
