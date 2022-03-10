package ca.sait.lab6.services;

import ca.sait.lab6.dataaccess.RoleDB;
import java.util.List;
import ca.sait.lab6.models.Role;

public class RoleService {
    private RoleDB roleDB = new RoleDB();
    
    public List<Role> getAll() throws Exception {
        List<Role> roles = this.roleDB.getAll();
        return roles;
    }
    public int getRoleID(String roleName) throws Exception{
        int id = this.roleDB.lookupRoleID(roleName);
        return id;
    }
}
