package ra.hn_jv240408_md3_webfilmonline.dao;

import ra.hn_jv240408_md3_webfilmonline.model.constant.Roles;
import ra.hn_jv240408_md3_webfilmonline.model.entity.Role;

public interface IRoleDao {
    Role getRoleName(Roles roleName);
}
