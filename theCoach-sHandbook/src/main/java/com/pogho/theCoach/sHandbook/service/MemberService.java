package com.pogho.theCoach.sHandbook.service;

import com.pogho.theCoach.sHandbook.DAO.Coach;
import com.pogho.theCoach.sHandbook.DTO.MemberDTO;
import com.pogho.theCoach.sHandbook.entities.CoachEntity;
import com.pogho.theCoach.sHandbook.entities.MemberEntity;
import com.pogho.theCoach.sHandbook.factory.CoachFactory;
import com.pogho.theCoach.sHandbook.mapper.MemberMapper;
import com.pogho.theCoach.sHandbook.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private CoachRepository coachRepository;

    private CoachFactory coachfactory = new CoachFactory();

    public MemberService() {
    }


    public ResponseEntity<MemberDTO> saveMember(MemberEntity memberEntity) throws IllegalArgumentException{
        if(memberEntity instanceof CoachEntity){
            Coach coach = coachfactory.createCoach((CoachEntity) memberEntity);
            coachRepository.save(coach);
            return new ResponseEntity<>(MemberMapper.toDto(coach), HttpStatus.CREATED);
        }
        else {
            throw new IllegalArgumentException("Unknown member type");
        }


    }

  //  public ResponseEntity<MemberDTO> updateMember(UUID oid, MemberEntity memberEntity) {
//        Optional<Member> optionalMember = memberRepository.findById(oid);
//        //if optional user exists get user, else return not found.
//        if(optionalMember.isPresent()){
//            MemberDTO memberDto =  MemberMapper.toDto(optionalMember.get());
//            return new ResponseEntity<>(memberDto, HttpStatus.OK);
//        }
//        else {
//            throw new NoUserFoundException();
//        }
  //  }

  //  public ResponseEntity deleteMember(UUID oid) {
//        Optional<Member> optionalMember = memberRepository.findById(oid);
//        //if optional user exists get user, else return not found.
//        if(optionalMember.isPresent()){
////          deleteMemberMethod
//            return new ResponseEntity<>( HttpStatus.OK);
//        }
//        else {
//            throw new NoUserFoundException();
//        }
    //}
}
