package xyz.blueskyan.pictureswall.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.blueskyan.pictureswall.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blueskyan
 * @since 2022-06-30
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
