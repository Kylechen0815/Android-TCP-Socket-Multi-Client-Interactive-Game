TCP 程式作業

1.TCP 的建立

我使用 c++來進行 host 端的建立，簡單來說，Host 端只負責將所有的client 鏈接起來，和信息交換的中繼，

host 端:

客戶端：

分爲主辦人和玩家 上面那張是玩家的 client 端，他只負責接受答案

而下面這張是主辦人的 client 端，只負責發答案

2.界面 UI 設計

3 游戲規則

玩家端先將 6 個號碼選擇好，然後按下 start 進入等待答案。這時候主辦人會進來公佈答案 一個一個按鈕挑選，被挑選到的答案如果玩家有選擇，顔色則會立即變爲綠色，如果沒有選擇則變爲粉色，如果玩家得到了4個綠色的答案則宣佈過關。


<img width="2000" height="2828" alt="image" src="https://github.com/user-attachments/assets/6d6cfc3f-932b-4afa-b572-b25abfab0468" />
<img width="2000" height="2828" alt="image" src="https://github.com/user-attachments/assets/9f7031cc-58a6-4951-90bf-a87af318038f" />
<img width="2000" height="2828" alt="image" src="https://github.com/user-attachments/assets/710edd57-5075-4864-bd32-69ca26d938e5" />
<img width="2000" height="2828" alt="image" src="https://github.com/user-attachments/assets/85a89357-deba-4b2e-8052-80f13770fd0d" />

