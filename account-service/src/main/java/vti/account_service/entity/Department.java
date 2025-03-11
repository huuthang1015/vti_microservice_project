package vti.account_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;


@Entity // no usages
@Getter
@NoArgsConstructor
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "total_member")
    private int totalMember;

    @Column(name = "type", columnDefinition = "ENUM('DEV', 'TEST', 'SCRUM_MASTER', 'PM')")
    @Enumerated(EnumType.STRING)
    private DepartmentType type;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private Date createdAt;

    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

    public enum DepartmentType { // 3 usages
        DEV, TEST, SCRUM_MASTER, PM; // no usages

        public static DepartmentType toEnum(String type) { // no usages
            for (DepartmentType item : values()) {
                if (item.toString().equals(type)) return item;
            }
            return null;
        }
    }
}

