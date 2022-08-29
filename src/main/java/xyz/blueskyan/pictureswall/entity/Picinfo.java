package xyz.blueskyan.pictureswall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author blueskyan
 * @since 2022-06-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;

    private String description;

    private String fullsLoc;

    private String thumbsLoc;

    private Date datetime;

    private String roleid;

}
