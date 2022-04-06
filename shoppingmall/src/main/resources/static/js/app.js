//$(document).ready(function() {  })
// $(function() { }) 위, 아래 동일함 준비되면 자동으로 시작
$(function () {
  $('a.deleteConfirm').click(function () {
    if (!confirm('삭제하겠습니까?')) return false; // 취소시 삭제안됨
  });
});
