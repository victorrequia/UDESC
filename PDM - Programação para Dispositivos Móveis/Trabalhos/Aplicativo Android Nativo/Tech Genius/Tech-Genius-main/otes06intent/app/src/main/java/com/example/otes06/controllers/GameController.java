package com.example.otes06.controllers;

import android.util.Log;

import com.example.otes06.models.Answer;
import com.example.otes06.models.Question;
import com.example.otes06.models.User;

import com.example.otes06.repository.AnswerRepository;
import com.example.otes06.repository.QuestionRepository;
import com.example.otes06.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class GameController {

    private AnswerRepository ar;
    private QuestionRepository qr;
    public User user = new User();

    public GameController(){

    }


    public User createUser() {
        return new User();
    }

    public List<Question> getQuestionToPlay(int easy, int medium, int hard){
        List<Question> allQuestions = getQuestions();

        List<Question> easyQuestions = shuffleList(allQuestions.subList(0,10));
        List<Question> mediumQuestions = shuffleList(allQuestions.subList(10,20));
        List<Question> hardQuestions = shuffleList(allQuestions.subList(20,30));

        List<Question> questionToPlay = easyQuestions.subList(0,easy);
        questionToPlay.addAll(mediumQuestions.subList(0,medium));
        questionToPlay.addAll(hardQuestions.subList(0,hard));

        return shuffleList(questionToPlay);
    }

    public List<User> getRanking(){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Map<String, String>>> typeReference = new TypeReference<>() {};
        var utils = new Utils();
        String jsonString = utils.userRanking;
        List<Map<String, String>> listaMapQuestions = new ArrayList<>();

        try {
            listaMapQuestions = objectMapper.readValue(jsonString, typeReference);
        } catch (Exception e){
            e.printStackTrace();
        }

        List<User> userList = new ArrayList<>();
        for(Map<String,String> json : listaMapQuestions){
            User user = new User(json.get("name"),Integer.parseInt(json.get("score")));
            userList.add(user);
        }

        return userList;
    }

    public List<Question> getQuestions(){

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Map<String, String>>> typeReference = new TypeReference<>() {};
        Utils utils = new Utils();
        String jsonString = utils.questions;
        List<Map<String, String>> listaMapQuestions = new ArrayList<>();
        try {
            listaMapQuestions = objectMapper.readValue(jsonString, typeReference);

        } catch (Exception e){
            e.printStackTrace();

        }

        List<Question> questionList = new ArrayList<>();
        for(Map<String,String> json : listaMapQuestions){
            int id = Integer.parseInt(json.get("id"));
            List<Answer> answers = findAnswersById(id);
            Question question = new Question(id,json.get("question_text"),Integer.parseInt(json.get("difficult")),answers);
            questionList.add(question);
        }

        return questionList;
    }

    public List<Answer> getAnswers(){

        Utils utils = new Utils();
        String jsonString = utils.answers;

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Map<String,String>>> typeReference = new TypeReference<>() {};


        List<Map<String, String>> answerList = new ArrayList<>();
        try {
            answerList = objectMapper.readValue(jsonString, typeReference);


        } catch (Exception e){
            e.printStackTrace();
//
        }


        List<Answer> answersList = new ArrayList<>();
        for( Map<String, String> json : answerList){

            Log.i("Teste2",json.toString());
            try {

                Answer answer =
                        new Answer(Integer.parseInt(json.get("id")),Integer.parseInt(json.get("question_id")),Boolean.valueOf(json.get("correct_answer")),json.get("answer_text"));

                answersList.add(answer);
            }catch (Exception e){
                Log.i("RESPONSETest",e.toString());
            }

        }

        return answersList;
    }

    public List<Answer> findAnswersById(int id){
        var list = getAnswers();
        List<Answer> returnList = new ArrayList<>();
        for(Answer answer: list){
            if(answer.getQuestionID() == id){
                returnList.add(answer);
            }
        }
        return shuffleList(returnList);
    }

    public static <T> List<T> shuffleList(List<T> list) {
        Collections.shuffle(list);
        return list;
    }
}
