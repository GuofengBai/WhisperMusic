function searchMusic(){
    var key=document.getElementById("keyword").value;

    $.ajax({
        url : 'http://localhost:3000/search?keywords='+key,
        data : {
        },
        dataType : 'json',
        type : 'get',
        success: function (result) {
            songs=result.songs;
            var str="";
            for(song in songs){
                str=str+'<tr><td><p>'+song.name+'</p>'+'</td>' +'</tr>' ;
                $("#songtable").html(str)
            }

        },
        error:function(err){
            location.reload(true);
            alert('搜索失败！');
        }
    });

}