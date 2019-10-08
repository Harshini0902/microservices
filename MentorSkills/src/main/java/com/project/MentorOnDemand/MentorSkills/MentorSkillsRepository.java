package com.project.MentorOnDemand.MentorSkills;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface MentorSkillsRepository extends CrudRepository<MentorSkills, String> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE mentor_skills SET mentor_name=?1 WHERE skill_id=?2",nativeQuery = true)
    void updateMentorName(String userName,int skillId);


}
