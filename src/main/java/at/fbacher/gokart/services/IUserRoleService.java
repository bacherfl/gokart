package at.fbacher.gokart.services;

import java.util.List;

import at.fbacher.gokart.model.UserRole;

public interface IUserRoleService {
	public void addUserRole(UserRole role);
	public void deleteUserRole(UserRole role);
	public void updateUserRole(UserRole role);
	public List<UserRole> getUserRoles(UserRole role);
}
