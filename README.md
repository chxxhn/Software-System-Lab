# Software-System-Lab 🚀

## 📌 프로젝트 개요
이 레포지토리는 **안드로이드 개발 실습 프로젝트 모음**입니다.  
**Kotlin**을 기반으로 UI 구성, 네트워크 통신, 데이터 관리, Google Maps API, Firebase, 머신러닝 등을 실습하며 Android 개발에 필수적인 다양한 기능들을 구현합니다.

---

## 📂 프로젝트 목록

### 📌 **1. Kotlin 프로그래밍 기초 (Project #1)**
- **기능:** Kotlin 기본 문법 학습 (변수, 함수, 조건문, 반복문, 컬렉션, 형 변환)
- **사용 기술:** `val/var`, `fun()`, `if-else`, `when`, `for`, `while`, `toString()`, `Enum class`

### 📌 **2. Kotlin 프로그래밍 중급 (Project #2)**
- **기능:** 예외처리, 클래스 및 상속, 람다함수, 고차함수, 확장함수, 오버로딩, 오버라이딩
- **사용 기술:** `try-catch`, `throw`, `class`, `inheritance`, `lambda`, `high-order function`, `extension function`, `override`
  
### 📌 **3. View, Widget, Layout (Project #3)**
- **기능:** 버튼 릴레이, 이미지 갤러리, 동적 UI 변경, 간단한 계산기
- **사용 기술:** `View`, `Button`, `ImageView`, `TextView`, `ConstraintLayout`

### 📌 **4. Jetpack Library (Project #4)**
- **기능:** `Fragment`, `RecyclerView`, `ViewPager2`, `DrawerLayout`을 활용한 UI 구성
- **사용 기술:** `androidx.fragment`, `RecyclerView.Adapter`, `FragmentStateAdapter`

### 📌 **5. Activity & Intent (Project #5)**
- **기능:** `Intent`를 사용한 액티비티 간 데이터 전달 및 결과 반환
- **사용 기술:** `startActivityForResult()`, `putExtra()/getExtra()`, `setResult()`

### 📌 **6. 네트워크 & HTTP 통신 (Project #6)**
- **기능:** `Volley` 및 `Retrofit`을 활용한 HTTP 요청, 파일 다운로드, 이미지 로드
- **사용 기술:** `RequestQueue`, `DownloadManager`, `Glide`

### 📌 **7. Firebase & Google Maps (Project #7)**
- **기능:** Firestore 데이터 저장 및 실시간 동기화, Google Maps API 활용
- **사용 기술:** `Firebase Firestore`, `GoogleMap`, `FusedLocationProviderClient`

### 📌 **8. 내부 데이터 관리 (Project #8)**
- **기능:** SQLite 데이터베이스, 내부/외부 파일 저장, SharedPreferences 활용
- **사용 기술:** `SQLiteDatabase`, `FileOutputStream`, `getSharedPreferences()`

### 📌 **9. 머신러닝 - TensorFlow Lite (Project #9)**
- **기능:** MNIST 숫자 분류 모델 학습, TensorFlow Lite 변환 및 Android 적용
- **사용 기술:** `TensorFlow Lite`, `Interpreter`, `ByteBuffer`

---

## 🛠 사용된 기술 스택
- **언어:** Kotlin
- **UI 구성:** 
  - `View`, `Fragment`, `RecyclerView`, `ViewPager2`
  - `DrawerLayout`, `ConstraintLayout`, `GridLayout`
- **네트워크:** 
  - `Volley` → HTTP 요청 및 응답 처리
  - `Retrofit` → REST API 통신 및 JSON 데이터 변환
  - `DownloadManager` → 파일 다운로드 기능
- **데이터베이스:** 
  - `SQLiteDatabase` → 로컬 데이터 저장 및 쿼리 실행
  - `SharedPreferences` → 앱 설정값 저장
  - `Firebase Firestore` → 클라우드 데이터 저장 및 실시간 동기화
- **지도 및 위치:** 
  - `Google Maps API` → 지도 및 위치 정보 활용
  - `FusedLocationProviderClient` → 현재 위치 추적 및 업데이트
- **머신러닝:** 
  - `TensorFlow Lite` → 경량화된 ML 모델 실행
  - `Interpreter` → TFLite 모델 로드 및 추론 수행
  - `ByteBuffer` → 이미지 데이터를 모델 입력으로 변환
- **파일 관리:** 
  - `FileOutputStream`, `FileInputStream` → 내부 저장소 파일 읽기/쓰기
  - `getExternalFilesDir()` → 외부 저장소 파일 관리
 




