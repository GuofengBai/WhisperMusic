function Ilike(id){
    if(!(id)) {
        alert('请输入全部字段！');
        return;
    }
    $.ajax({
        url : '/whisper/'+id+'/like',
        data : {
        },
        dataType : 'json',
        type : 'post',
        success: function (result) {
            location.reload(true);
            alert('赞成功！');
        },
        error:function(err){
            location.reload(true);
            alert('赞失败！');
        }
    });

}
function favourite(id){
    if(!(id)) {
        alert('请输入全部字段！');
        return;
    }
    $.ajax({
        url : '/whisper/'+id+'/favourite',
        data : {
        },
        dataType : 'json',
        type : 'post',
        success: function (result) {
            location.reload(true);
            alert('赞成功！');
        },
        error:function(err){
            location.reload(true);
            alert('赞失败！');
        }
    });

}