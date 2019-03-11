function searchMusic(){
    var key=document.getElementById("keyword").value;

    $.ajax({
        url : 'http://localhost:3000/search?keywords='+key,
        data : {
        },
        dataType : 'json',
        type : 'get',
        success: function (result) {
            var songs=result.result.songs;
            for(var i in songs){
                var str='<tr><td>'+songs[i].name+' - '+songs[i].artists[0].name+'</td>' +'</tr>' ;
                $("#songtable").append(str)
            }

        },
        error:function(err){
            location.reload(true);
            alert('搜索失败！');
        }
    });

}