/**
 * Created by t on 2017/1/8.
 */
var xmlHttp;
function createXMLHTTP() {
    if (window.XMLHttpRequest){
        xmlHttp = new XMLHttpRequest();
    }
    else if (window.ActiveXObject){
        try
        {
            xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
        }
        catch (e) {}
        try{
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }catch(e) {}
        if (!xmlHttp){
            window.alert("不能创建XMLHttpRequest对象实例");
            return false;
        }
    }
}
function ModifyScore() {
    console.log(xmlHttp.readyState+" "+xmlHttp.status+" "+xmlHttp.responseText);
    if (xmlHttp.status ==200)
    {
        if (xmlHttp.readyState==4){
            alert("操作成功！");
            //  if(xmlHttp.responseText=="true");
        }
    }
    else {

        element.innerHTML=oldcontent;
        alert("操作失败，请重新尝试！");
    }
}