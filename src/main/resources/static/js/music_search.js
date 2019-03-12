function searchMusic(){
    var key=document.getElementById("keyword").value;
    $.ajax({
        url : 'http://localhost:3000/search?keywords='+key,
        data : {
        },
        dataType : 'json',
        type : 'get',
        success: function (result) {
            document.getElementById('songtable').innerHTML='<thead>' +
                '            <tr>' +
                '                <td>音乐列表</td>' +
                '                <td>操作</td>' +
                '            </tr>' +
                '            </thead>';
            var songs=result.result.songs;
            for(var i in songs){
                var str='<td>'+songs[i].name+' - '+songs[i].artists[0].name+'</td>' ;
                str=str+'<td>'+'<button class=\"btn btn-primary\" type=\"button\" onclick=\"javascript:musicChange('+songs[i].id+')\">播放</button>'+'</td>';
                str=str+'<td>'+'<a href=\"/whisper/new/'+songs[i].id+'/'+songs[i].name+'\">'+'<button class=\"btn btn-primary\" type=\"button\">创建悄悄话</button>'+'</a>'+'</td>';
                str='<tr>'+str+'</tr>';
                $("#songtable").append(str)
            }

        },
        error:function(err){
            location.reload(true);
            alert('搜索失败！');
        }
    });

}

function  musicChange(id) {
    var url="//music.163.com/outchain/player?type=2&id="+id+"&auto=1&height=32";
    document.getElementById('music_player').src=url;

}