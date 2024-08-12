package ra.hn_jv240408_md3_webfilmonline.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "firm_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", nullable = false, length = 50, unique = true)
    @NotBlank(message = "Tên danh mục không để trống")
    @NotBlank(message = "Tên danh mục đã tồn tại")
    private String categoryName;

    @Column(name = "status")
    private Boolean status = true;
}
