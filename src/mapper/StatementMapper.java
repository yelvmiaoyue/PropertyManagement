package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import pojo.SearchData;
import pojo.Statement;

public interface StatementMapper {
	@Select("select title from statements order by id desc limit #{pageStart},#{pageSize}")
	List<Statement> selAllTitles(SearchData data);

	@Select("select title,content from statements where title=#{title}")
	Statement selContent(String title);

	@Insert("insert into statements (title,content,id) values(#{title},#{content},default)")
	boolean insStatement(Statement stat);

	@Select("select count(title) from statements")
	int selTotal();

	@Select("select count(title) from statements where title=#{title}")
	int selTitleCheck(String title);
}
