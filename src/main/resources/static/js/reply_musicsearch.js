function replyMusic_searchMusic() {
    var key = document.getElementById("keyword").value;
    $.ajax({
        url: 'http://172.19.240.204:3000/search?keywords=' + key,
        data: {},
        dataType: 'json',
        type: 'get',
        success: function (result) {
            document.getElementById('songtable').innerHTML = '<thead>' +
                '            <tr>' +
                '                <td>音乐列表</td>' +
                '                <td>操作</td>' +
                '            </tr>' +
                '            </thead>';
            var songs = result.result.songs;
            for (var i in songs) {
                if (songs[i].fee === 0) {
                    var name=songs[i].name + ' - ' + songs[i].artists[0].name;
                    var str = '<td>' + name + '</td>';
                    str = str + '<td>' + '<button class=\"btn btn-primary\" id=\"playMusic\" type=\"button\" onclick=\"javascript:replyMusic_musicChange(' + songs[i].id + ')\">播放</button>' + '</td>';
                    str = str + '<td>' + '<button class=\"btn btn-primary\" type=\"button\" onclick=\"javascript:replymusic_favourite(' + songs[i].id +',\''+name+ '\')\">收藏</button>' + '</td>';
                    str = str + '<td>' + '<button class=\"btn btn-block\" id="addMusic" type=\"button\" onclick=\"javascript:replyMusic_musicAdd(' + songs[i].id + ','+'\''+name+'\''+')\">加入到回复</button>' + '</td>';
                    str = '<tr>' + str + '</tr>';
                    $("#songtable").append(str)
                }
            }

        },
        error: function (err) {
            location.reload(true);
            alert('搜索失败！');
        }
    });

}

function replyMusic_musicChange(id) {
    var url = "//music.163.com/outchain/player?type=2&id=" + id + "&auto=1&&height=66";
    document.getElementById('music_player_reply').src = url;
}

function replyMusic_musicAdd(id, name) {
    document.getElementById('hasMusic').setAttribute('value', 'true');
    document.getElementById('musicId').setAttribute('value', id);
    document.getElementById('musicName').setAttribute('value', name);
}
function replymusic_favourite(id,name){
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
function replyMusic_unfavourite(id) {
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