package ra.hn_jv240408_md3_webfilmonline.model.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = 100, nullable = false, unique = true)
//    @NotBlank(message = "Email không được để trống")
//    @NotBlank(message = "Email đã tồn tại")
    private String email;

    @Column(name = "userName", length = 50, nullable = false)
//    @NotBlank(message = "Tên không được để trống")
    private String userName;

    @Column(name = "password", nullable = false, length = 8)
//    @NotBlank(message = "Mật khẩu không để trống")
    private String password;

    @Column(name = "fullName", length = 100, nullable = false)
//    @NotBlank(message = "Họ và tên không để trống")
    private String fullName;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "phone")
//    length = 11, nullable = false, unique = true
//    @NotBlank(message = "Số điện thoại không được để trống")
//    @NotBlank(message = "Số điện thoại đã tồn tại")
    private String phone;

    @Column(name = "createdDate")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @PastOrPresent(message = "Thời gian cập nhật phải ở quá khứ hoặc hiện tại")
    private Date createdDate;

    @Column(name = "updatedDate")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @PastOrPresent(message = "Thời gian cập nhật phải ở quá khứ hoặc hiện tại")
    private Date updatedDate;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "isDelete")
    private Boolean isDelete;

    @Column(name = "status")
    private Boolean status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet;

}
