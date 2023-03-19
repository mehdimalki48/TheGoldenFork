package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: MenuType
 *
 */
@Entity
@Table(name = "tbl_menu_type")
public class MenuType implements Serializable {
	
	// Parent : a menuType Can have multiple 
	// menus and a menu must be in one and only one type.
	   
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menu_type_id;
	private String type_name;
	private String description;
	
	
	@OneToMany(mappedBy = "menuType", cascade = CascadeType.ALL)
	protected Set<Menu> menus = new HashSet<>();

	public MenuType(String description, String type_name) {
		super();
		this.type_name = type_name;
		this.description = description;
	}
	
	public MenuType() {
		super();
	}


	public int getMenu_type_id() {
		return menu_type_id;
	}

	public void setMenu_type_id(int menu_type_id) {
		this.menu_type_id = menu_type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
   
}
