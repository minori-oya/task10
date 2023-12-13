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
