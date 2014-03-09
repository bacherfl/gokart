package at.fbacher.gokart.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import at.fbacher.gokart.model.UserRole;

@Stateless
public class UserRoleServiceBean implements IUserRoleService {

	@Inject
	private EntityManager em;
	
	@Override
	public void addUserRole(UserRole role) {
		em.persist(role);
	}

	@Override
	public void deleteUserRole(UserRole role) {
		UserRole managedUserRole = em.find(UserRole.class, role.getId());
		em.remove(managedUserRole);
	}

	@Override
	public void updateUserRole(UserRole role) {
		em.merge(role);
	}

	@Override
	public List<UserRole> getUserRoles(UserRole role) {
		TypedQuery<UserRole> query = em.createNamedQuery(UserRole.findAll, UserRole.class);
		return query.getResultList();
	}

}
