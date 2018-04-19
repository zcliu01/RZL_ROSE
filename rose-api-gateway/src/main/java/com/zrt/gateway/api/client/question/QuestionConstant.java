/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zrt.gateway.api.client.question;

/**
 *
 * @author dedrp
 */
public interface QuestionConstant {
	String HYSTRIX_TIMEOUT = "3000";

	String QUESTION_INSTANCE = "questionnaire";
//	String QUESTION_INSTANCE = "questionnaireZqw";

	//问题保存
	String QUESTION_SAVE="/v1.0/question/save";
	//问题查询
	String QUESTION_SEARCH="/v1.0/question/search";
	//问题删除
	String QUESTION_DELETE="/v1.0/question/delete";



	//问卷保存
	String PAPER_SAVE="/v1.0/paper/save";
	//问卷查询
	String PAPER_SEARCH="/v1.0/paper/search";
	//试卷删除
	String PAPER_DELETE="/v1.0/paper/del";
	//试卷撤销
	String PAPER_CANCEL="/v1.0/paper/cancel";
	//试卷发布
	String PAPER_PUBLISH="/v1.0/paper/publish";

}
