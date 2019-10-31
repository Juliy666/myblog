package cn.juliy.myblog.mapper;

import cn.juliy.myblog.entity.SysMenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {
    /**
     * 根据父菜单查询子菜单
     * @param parentId 父菜单Id
     */
    List<SysMenuEntity> queryListParentId(Long parentId);
}
