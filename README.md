# 概要
とある証券会社の顧客管理アプリケーションを作成しています。
主な機能は顧客情報の取得、登録、更新、削除となります。

# 制作背景
前職の証券会社では顧客管理をExcelで行っており、誰がいつ更新しているかが分かりにくく、入力値の入れ違いや、最新のデータが分かりづらいといった問題がありました。
特定の顧客データをIDで管理することで探す時間ロスによる業務効率化を実現するため、シンプルで顧客管理機能に特化したアプリケーションを開発しようと思いました。
## PC環境
OS macOS 14.0  
CPU Apple M2

## 開発環境
* IntelliJ IDEA  
* 言語：Java
* フレームワーク：Spring Framework
* DB：MySQL
* 環境：Mac、Docker
* ソース管理：Git
* プロジェクト管理：GitHub

# アプリケーションの仕様
## URL設計
|HTTPメソッド|URL|処理内容|  
|---|---|---|  
|GET|{id}|顧客情報の読み取り(取得)|  
|POST|clients|顧客情報の登録|  
|PATCH|clients/{id}|顧客情報の更新|  
|DELETE|clients/{id}|顧客情報の削除|  
## データベースの設定

|カラム名(論理名)|カラム名(物理名)|型|  
|---|---|---|  
|ID|id|int|  
|名前|name|varchar(60)|  
|年齢|age|int|  
|電話番号|phoneNumber|varchar(15)| 
|アドレス|address|varchar(100)|  
## Spring Bootの設定

|Project|Gradle Project|  
|---|---|  
|Language|Java|  
|Spring Boot|3.0.0|  
|packing|Jar|  
|Java|17|  


# CRUD処理　概要
顧客のログイン情報テーブルを作成し、CRUD処理を実装いたしました。  
また、Create処理,Update処理,Delete処理にはバリデーションも実装しました。  

#### [使用バリデーション一覧]
<img width="282" alt="スクリーンショット 2023-10-21 19 20 16" src="https://github.com/minori-oya/task10/assets/138114043/6387a9f4-a260-41c7-8244-e2575f448896">


# 動作確認
#### [MySQLのデータベース]
<img width="212" alt="db" src="https://github.com/minori-oya/task10/assets/138114043/0135a765-1950-441d-bcaf-5c595feef989">


#### [clientsテーブル]
<img width="365" alt="テーブル" src="https://github.com/minori-oya/task10/assets/138114043/1f48f35f-6031-4ef9-afba-0f96dd341822">

## Read処理
* 顧客データの全件取得、特定のIDで検索したデータの取得を実装しています。

### 顧客データの全件取得 *"client"*
![GET200](https://github.com/minori-oya/task10/assets/138114043/d7cacabe-a381-414a-8e82-f73537a32326)

### 特定のIDで検索したデータの取得 *"client/{id}"*
 特定のID情報取得のレスポンスはステータスコード200を想定し、存在しないIDをリクエストした場合は400を想定しています。

####  [特定のID情報を取得]
![GET ID2](https://github.com/minori-oya/task10/assets/138114043/e2c6debb-98c9-4edf-8f55-149b9ad02cce)

#### [存在しないIDをリクエストした時の例外処理]
![GET ID99](https://github.com/minori-oya/task10/assets/138114043/50d329a9-b547-4fe2-94d2-d2b2068c62b8)

## Create処理
* 新規顧客データの登録を実装しています。

### 新規顧客データの登録 *"client"*
#### [clientsテーブル]
<img width="749" alt="create処理　sql" src="https://github.com/minori-oya/task10/assets/138114043/1f2d6254-6468-424d-a7bc-2a7144724650">

成功レスポンスはステータスコード201を想定し、バリデーション実装によりバッドリクエストの場合は400を想定しています。

#### [新規テーブルを登録]
![POST](https://github.com/minori-oya/task10/assets/138114043/f9136647-294b-4e3e-98fe-4f3018d4b23c)

![POST 詳細](https://github.com/minori-oya/task10/assets/138114043/172c7d24-fd66-4206-b81f-615194eccd39)


#### [nameフィールドが空文字の場合]
![POST name空文字](https://github.com/minori-oya/task10/assets/138114043/fe43f8bd-591a-4937-95da-05fb37441ae5)


#### [ageフィールドが20の場合]
![POST age20](https://github.com/minori-oya/task10/assets/138114043/de7a73a4-94dd-4392-b599-f7785511176c)


#### [ageフィールドが19の場合]
![POST age19](https://github.com/minori-oya/task10/assets/138114043/64d65af8-c180-4329-8521-ea37d65973c2)

#### [ phoneNumberフィールドが9桁の場合]
![POST phoneNumber9](https://github.com/minori-oya/task10/assets/138114043/50d3d09e-5363-4efb-90f5-08a59bd0ef5a)


## Update処理
* clientsテーブルのID３の顧客の「年齢」と「電話番号」を更新する処理を実装しました。
* 存在しないIDの顧客データを更新しようとすると、ステータスコード４０４でエラーを返すバリデーション処理も実装しています。

### 顧客データの更新 *"client/{id}"*
レスポンス成功はステータスコード200を想定し、存在しないIDをリクエストした場合は404を想定しています。
#### [ID3を更新処理]

```java
curl --location --request PATCH 'http://localhost:8080/clients/3' \
--header 'Content-Type: application/json' \
--data '{
    "age": 31,
    "phoneNumber": "08055555555"
}'
```
![PATCH ID3](https://github.com/minori-oya/task10/assets/138114043/01ccf617-cc31-42aa-93fe-4f9d02da21c0)

#### [存在しないIDをリクエストした時の例外処理]

```java
curl --location --request PATCH 'http://localhost:8080/clients/99' \
--header 'Content-Type: application/json' \
--data '{
    "age": 31,
    "phoneNumber": "08055555555"
}'
```
![PATCH ID99](https://github.com/minori-oya/task10/assets/138114043/8818c5a3-5aae-4bcd-a81b-0549dc0dcbe6)

#### [clientsテーブル]　
**変更前**
![変化前](https://github.com/minori-oya/task10/assets/138114043/17fccee1-1313-4562-bf60-c94715dcec58)

**変更後**
<img width="346" alt="変更後　" src="https://github.com/minori-oya/task10/assets/138114043/5c3a6d53-e3ca-441d-a1de-dc45524486c0">

## Delete処理
* clientsテーブルのID４の顧客データを削除する処理を実装しました。
* 存在しないIDの顧客データを削除しようとすると、エラーを返すバリデーションも併せて実装いたしました。

### 顧客データの削除　*"clients{id}"*
レスポンス成功はステータスコード２００を想定し、存在しないIDをリクエストした場合は４０４を想定しています。
#### [ID4を削除処理]　
```java
curl --location --request DELETE 'http://localhost:8080/clients/4' \
```
![DELETE id4](https://github.com/minori-oya/task10/assets/138114043/104d0047-dcc7-4ffc-b51d-ee8c5e8e36f3)
#### [存在しないIDをリクエストした時の例外処理]
```java
curl --location --request DELETE 'http://localhost:8080/clients/99' \
```
![DELETE id99](https://github.com/minori-oya/task10/assets/138114043/162c5559-9892-40a1-ab06-522c0352da6d)
#### [clientsテーブル]
**変更前**
![DELETE 変更前](https://github.com/minori-oya/task10/assets/138114043/175b2fbf-3223-4ce6-84e3-412b0f252622)
**変更後**
![DELETE 変更後](https://github.com/minori-oya/task10/assets/138114043/3c6d3337-70f2-4deb-8d26-a6544b273cd8)

