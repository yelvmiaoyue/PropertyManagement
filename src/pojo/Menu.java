package pojo;

import java.util.List;

public class Menu {
	private int id;
	private String name;
	private int pid;
	private String link;
	private List<Menu> children;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", pid=" + pid + ", children=" + children + "]";
	}

}
