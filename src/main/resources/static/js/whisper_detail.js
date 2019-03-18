function replylike(id){
    if(!(id)) {
        alert('请输入全部字段！');
        return;
    }
    $.ajax({
        url : '/reply/'+id+'/like',
        data : {
        },
        dataType : 'json',
        type : 'post',
        success: function (result) {
            location.reload(true);

        },
        error:function(err){
            location.reload(true);
            alert('赞失败！');
        }
    });

}
function whisperlike(id){
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
        url : '/whisper/'+id+'/favorite',
        data : {
        },
        dataType : 'json',
        type : 'post',
        success: function (result) {
            location.reload(true);

        },
        error:function(err){
            location.reload(true);
            alert('收藏失败！');
        }
    });

}
function unfavourite(id){
    if(!(id)) {
        alert('请输入全部字段！');
        return;
    }
    $.ajax({
        url : '/whisper/'+id+'/unfavorite',
        data : {
        },
        dataType : 'json',
        type : 'post',
        success: function (result) {
            location.reload(true);

        },
        error:function(err){
            location.reload(true);
            alert('取消收藏失败！');
        }
    });

}


function favouriteMusic(id,name){
    if(!(id)) {
        alert('请输入全部字段！');
        return;
    }
    $.ajax({
        url : '/music/'+id+'/favorite?musicName='+name,
        data : {
        },
        dataType : 'json',
        type : 'post',
        success: function (result) {
            alert('收藏成功！');

        },
        error:function(err){
            location.reload(true);
            alert('收藏失败！');
        }
    });

}

function unfavouriteMusic(id) {
    if (!(id)) {
        alert('请输入全部字段！');
        return;
    }
    $.ajax({
        url: '/music/' + id + '/unfavorite',
        data: {},
        dataType: 'json',
        type: 'post',
        success: function (result) {
            location.reload(true);

        },
        error: function (err) {
            location.reload(true);
            alert('取消收藏失败！');
        }
    });
}