package me.springboot.gethwithmaven;

public class GethResultVO {

    private String jsonrpc;
    private String id;
    private String result;

    public String getJsonrpc() {
        return jsonrpc;
    }
    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "\nGethResultVO{" +
                "jsonrpc='" + jsonrpc + '\'' +
                ", id='" + id + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
