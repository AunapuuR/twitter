package jp.kobe_u.cs.daikibo.Rainer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobe_u.cs.daikibo.Rainer.entity.Rainer;
import jp.kobe_u.cs.daikibo.Rainer.repository.RainerRepository;

@Service
public class RainerService {
    @Autowired
    RainerRepository repo; // レポジトリ
    // つぶやきを投稿
    public Rainer postRainer(Rainer t) {
        //名前がない場合の業務ロジック
        String name = t.getName();
        if (name==null || name.length()==0) {
            t.setName("名無しさん");
        }
        t.setCreatedAt(new Date());  //作成日時をセット
        return repo.save(t); //セーブしたオブジェクトを返却
    }
    // 全つぶやきを取得

    public List<Rainer> getAllRainer() {
        Iterable<Rainer> found = repo.findAll();
        ArrayList<Rainer> list = new ArrayList<>();
        found.forEach(list::add);
        return list;
    }

    public List<Rainer> searchRainer(String keyword) {
        return repo.findByCommentContaining(keyword);
    }
}

