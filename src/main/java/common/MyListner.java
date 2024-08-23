package common;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

//Listen 듣고 있는 형태? 특정한 사건이 발생하면 그때 리액션을 해줌
//Listener는 행동하는 반응하는 거. 이벤트(사건) 정보라던가, 그걸 했을때 실행할 코드 이런걸 사용하는거
//자바스크립트의 eventListener랑 비슷함. 다만 여기는 서버가 열리거나 종료되거나 하는 것
//즉, session이 변경되거나 요청이 변경되거나 하는 식
//servletcontext=application context pageContext, request session application 3개가 값이 변경될때 하는게 listner
//static은 자바 listener는 톰캣 서버를 활용하는거
public class MyListner implements HttpSessionAttributeListener {
	//session의 속성값이 추가되거나 삭제되거나 변경될때 아래 함수들이 실행된다는 뜻
	public void attributeAdded(HttpSessionBindingEvent se)  {
    	System.out.println("세션에 데이터가 추가됨");
    }
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    }
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    }
}
