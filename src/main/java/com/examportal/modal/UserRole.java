package com.examportal.modal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_role")
public class UserRole {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long userRoleId;
		
		//mapping
		
		@ManyToOne(fetch = FetchType.EAGER)
		private User user;
		
		@ManyToOne
		private Role role;
		

		public Long getUserRoleId() {
			return userRoleId;
		}

		public void setUserRoleId(Long userRoleId) {
			this.userRoleId = userRoleId;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}
		
		
}
