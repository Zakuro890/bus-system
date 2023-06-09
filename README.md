# bus-system

【予約バスシステムのドキュメント】<br>

# 概要<br>
予約バスシステムは、架空のバス会社が運行するバスの座席予約をオンライン上で行うシステムです。<br>利用者は、自宅や外出先からインターネットを介して、バスの空席状況を確認し、予約をすることができます。

# 機能<br>
予約バスシステムには以下のような機能があります。

・バスの運行スケジュールの確認<br>
・空席状況の確認<br>
・座席の選択、予約、キャンセル<br>
※支払いは　当日に直接払うようにしています。<br>
# 利用方法<br>
予約バスシステムを利用するには、以下の手順が必要です。<br>
1.インターネットに接続し、バス会社の予約サイトにアクセスする<br>
2.ジュールからバスの日時を選択する<br>
3.状況を確認し、希望の座席を選択する<br>
4.事項（名前、電話番号など）を入力し、予約する<br>
# 変数の説明
```
int Resarve = bean.getResarve();
String Name = bean.getName();
String Tel = bean.getTel();
int Dating = bean.getDating();
String Drive = bean.getDrive();
String Route = bean.getRoute();
String Seanum = bean.getSeanum();
```
上記のコードは、Beanクラスのインスタンスから各フィールドの値を取得し、それぞれの変数に代入しています。Resarveは予約番号、Nameは名前、Telは電話番号、Datingは日付、Driveは運転者、Routeは路線、Seanumは席番号を表します。
# 仕組み<br>
予約バスシステムは、以下のような仕組みで動作しています。<br>
1.社が、予約システムに運行スケジュール、座席情報、料金情報などを登録する<br>
2.ザーが、予約システムにアクセスし、バスの空席状況や料金などを確認する<br>
3.ーが、希望の座席を選択し、予約をする<br>
4.が完了すると、予約一覧画面に予約情報が表示される。<br>
5.ザーは、バスに乗車し、予約した座席に着席する<br>
以上が、予約バスシステムのドキュメントです。<br>
