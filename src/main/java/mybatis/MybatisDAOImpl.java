package mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*
	해당 인터페이스는 컨트롤러와 DAO사이에서
	매개역할을 하는 서비스 객체로 사용한다.
	@Service 어노테이션은 빈을 자동으로 생성하기 위한 용도이지만
	여기서는 단순히 역할을 명시적으로 표현하기 위해 사용되었다.
	따라서 필수사항은 아니다.
 */
@Service
public interface MybatisDAOImpl {
	/*
		방명록 1차버전에서 사용하는 메서드.
		게시물수 카운트와 목록에 출력할 게시물을 가져온다.
	 */
	public int getTotalCount();							  // 파라미터 없음
	public ArrayList<MyBoardDTO> listPage(int s, int e);  // 파라미터 2개있음
	
	/*
		방명록 2차버전에서 사용하는 메서드.
		파라미터를 저장한 DTO객체를 매개변수로 사용한다.
		즉, Mapper로 DTO를 통해 파라미터를 전달한다.
	 */
	public int getTotalCountSearch(ParameterDTO parameterDTO);							  // 파라미터 없음
	public ArrayList<MyBoardDTO> listPageSearch(ParameterDTO parameterDTO);  // 파라미터 2개있음
	
	// 글쓰기
	/**
	[파라미터를 받는 세번째 방법]
		: @Param 어노테이션을 통해 파라미터를 전달하면
		  Mapper에서는 별칭을 통해 인파라미터를 처리할 수 있다.
	 */
	public int write(
		@Param("_name") String name,
		@Param("_contents") String contents,
		@Param("_id") String id
	);
	
	// 수정페이지 진입시 기존 게시물의 내용을 읽어오기 위한 메서드
	public MyBoardDTO view(ParameterDTO parameterDTO);
	// 수정처리
	public int modify(MyBoardDTO myBoardDTO);
	
	// 삭제처리
	public int delete(String idx, String id);
	
	
	// Map컬렉션 사용을 위한 추상메서드
	public ArrayList<MyBoardDTO> hashMapUse(Map<String, String> hMap);
	// List컬렉션 사용을 위한 추상메서드
	public ArrayList<MyBoardDTO> arrayListUse(List<String> aList);
}
