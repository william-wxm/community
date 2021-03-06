// This file is autogenerated via the `commonjs` Grunt task. You can require() this file in a CommonJS environment.
function collapseComment(e) {
    var dataId = e.getAttribute("data-id");
    var comment = $("#comment-"+dataId);
    //获取一下二级评论的展开状态
    var collapse = e.getAttribute("data-collapse");
    if (collapse) {
        //折叠二级评论
        comment.removeClass("in");
        e.removeAttribute("data-collapse");
    }else{
        //展开二级评论
        comment.addClass("in");
        //标记二级评论展开状态
        e.setAttribute("data-collapse","in");
    }
}

function post() {
    var questionId = $("#question_id").val();
    var comment = $("#comment_id").val();
   if (!comment) {
       alert("回复不能为空!!!");
       return;
   }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType:"application/json",
        data: JSON.stringify({

            "parentId":questionId,
            "content":comment,
            "type":1
        }),
        success: function (response) {
            if (response.code== 200) {
                $("#comment_section").hide();
                window.location.reload();
            }else{
                if (response.code == 20003) {
                    var conf = confirm(response.message);
                    if (conf) {
                        window.open("https://github.com/login/oauth/authorize?client_id=7e26b31604d5a9370055&redirect_uri=http://localhost:8080/callback&scope=user&state=1");
                        window.localStorage.setItem("closeable",true);
                    }
                }else {
                    alert(response.message);
                }
            }
        },
        dataType: "json"
    });
}
