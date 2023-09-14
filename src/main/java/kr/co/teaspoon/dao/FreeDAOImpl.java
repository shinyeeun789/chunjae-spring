package kr.co.teaspoon.dao;

import kr.co.teaspoon.dto.Free;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FreeDAOImpl implements FreeDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<Free> freeList() throws Exception {
        return sqlSession.selectList("free.freeList");
    }

    @Transactional
    @Override
    public Free freeDetail(int no) throws Exception {
        sqlSession.update("free.countUp");
        return sqlSession.selectOne("free.freeDetail", no);
    }

    @Override
    public void freeInsert(Free dto) throws Exception {
        sqlSession.insert("free.freeInsert", dto);
    }

    @Override
    public void freeDelete(int no) throws Exception {
        sqlSession.delete("free.freeDelete", no);
    }

    @Override
    public void freeEdit(Free dto) throws Exception {
        sqlSession.update("free.freeUpdate", dto);
    }
}
