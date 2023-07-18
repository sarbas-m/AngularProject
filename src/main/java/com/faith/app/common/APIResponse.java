package com.faith.app.common;

public class APIResponse {

private Integer status;
private Object data;
private Object error;

//Constructors
public APIResponse() {
super();
// TODO Auto-generated constructor stub
}

public APIResponse(Integer status, Object data, Object error) {
super();
this.status = status;
this.data = data;
this.error = error;
}

//Getters and Setters
public Integer getStatus() {
return status;
}

public void setStatus(Integer status) {
this.status = status;
}

public Object getData() {
return data;
}

public void setData(Object data) {
this.data = data;
}

public Object getError() {
return error;
}

public void setError(Object error) {
this.error = error;
}

//Display
public String toString() {
return "APIResponse [status=" + status + ", data=" + data + ", error=" + error + "]";
}
}