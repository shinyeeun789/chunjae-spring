package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.FileDTO;
import org.apache.ibatis.annotations.Insert;

// Mapper를 XML이 아닌 JAVA로 만들고 싶은 경우
// Mybatis를 사용하지 않고 mapper 생성하는 방법
public interface FileUploadMapper {

    @Insert("INSERT INTO attach (uuid, uploadpath, filename, filetype, bno) " +
            "VALUES (#{uuid}, #{uploadpath}, #{filename}, #{filetype}, #{bno}")
    public int insertAttach(FileDTO fileDTO);

}
