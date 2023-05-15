package kr.multi.erp.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class DeptDAOImpl implements DeptDAO {
	@Autowired
	//빈의 관계를 설정하고 필요한 객체를 주입받을 수 있도록 설정
	JdbcTemplate template;
	@Override
	public List<DeptDTO> getDeptName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(DeptDTO dept) {
		String sql = "insert into dept values (?,?,?,null,?,?,?,?,?,?,?)";
		return template.update(sql, dept.getDeptno(),dept.getDeptname(),dept.getDeptStartDay(),dept.getDeptlevel(),dept.getDeptstep()
				,dept.getDeptuppercode(),dept.getJob_category(),dept.getMgr_id(),dept.getDeptaddr(),dept.getDepttel()
				);

	}

	@Override
	public List<DeptDTO> select() {
		//jdbc작업할 때 작업했던 모든 코드가 query메소드 내부에서 자동으로 처리
		//매번 달라지는 sql문과 조회한 레코드를 어떤 dto에 매핑할 것인지 정보를 담고있는 RowMapper객체만 넘겨주면 자동으로
		//모든 레코드를 list로 만들어서 return
		return template.query("select * from dept", new DeptRowMapper());
	}

	@Override
	public int delete(String deptno) {
		// TODO Auto-generated method stub
		return template.update("delete from dept where deptno=?", deptno);
	}

	@Override
	public DeptDTO read(String deptno) {
		//레코드가 하나 ?가 2개 이상인 경우가 있어 object는 배열로 받는다.
		return template.queryForObject("select * from dept where deptno =?", new Object[] {deptno}, new DeptRowMapper());
	}

	@Override
	public int update(DeptDTO dept) {
		String sql = "update dept set mgr_id=?,deptaddr=?,depttel=? where deptno=?";
		return template.update(sql, dept.getMgr_id(),dept.getDeptaddr(),dept.getDepttel(),dept.getDeptno());
	}

}
