function searchMusic() {
    var key = document.getElementById("keyword").value;
    $.ajax({
        url: 'http://localhost:3000/search?keywords=' + key,
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
                    var str = '<td>' + songs[i].name + ' - ' + songs[i].artists[0].name + '</td>';
                    str = str + '<td>' + '<button class=\"btn btn-primary\" id=\"playMusic\" type=\"button\" onclick=\"javascript:musicChange(' + songs[i].id + ')\">播放</button>' + '</td>';
                    str = str + '<td>' + '<button class=\"btn btn-block\" id="addMusic" type=\"button\" onclick=\"javascript:musicAdd(' + songs[i].id + ','+'\''+songs[i].name+'\''+')\">加入到悄悄话</button>' + '</td>';
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

function musicChange(id) {
    var url = "//music.163.com/outchain/player?type=2&id=" + id + "&auto=1&&height=66";
    document.getElementById('music_player').src = url;
}

function musicAdd(id, name) {
    document.getElementById('hasMusic').setAttribute('value', 'true');
    document.getElementById('musicId').setAttribute('value', id);
    document.getElementById('musicName').setAttribute('value', name);
}