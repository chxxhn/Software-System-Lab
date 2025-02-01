# Project #9 - Machine Learning with TensorFlow Lite

## 📌 프로젝트 개요
**Kotlin을 이용한 Android 기계학습 및 TensorFlow Lite 실습 예제**들입니다.  
텐서플로 라이트를 활용한 모델 변환 및 로드, 입력 데이터 전처리, 추론 및 결과 해석 과정을 실습합니다.

---

## 🛠 실습 예제 목록
### 📌 **예제 1 - 텐서플로 라이트 개발환경 구축**
#### 1. **TensorFlow Lite 개요 및 개발환경 설정**
- 텐서플로 라이트의 특징 및 Android 앱에서의 활용 개념 학습
- 모델 변환 과정 (텐서플로 모델 → TFLite 모델) 이해
- Android 프로젝트에 TensorFlow Lite 라이브러리 추가

#### 2. **Colab을 이용한 모델 학습 및 변환**
- Google Colab에서 딥러닝 모델 생성 및 학습
- `TFLiteConverter`를 사용하여 학습된 모델을 `.tflite` 형식으로 변환
- 변환된 모델을 Android 앱에 추가하는 방법 학습 (`assets` 폴더 활용)

---

### 📌 **예제 2 - DrawActivity를 활용한 숫자 이미지 분류 앱 구현**
#### 1. **프로젝트 구성**
- `Empty Activity` 기반의 프로젝트 생성
- TensorFlow Lite, AndroidDraw 라이브러리 및 종속성 추가

#### 2. **TensorFlow Lite 모델 로드**
- `assets` 폴더에 `tflite` 모델 추가 및 로드 과정 구현
- `MappedByteBuffer`를 활용한 모델 로드
- `Interpreter`를 사용하여 모델 추론 기능 추가

#### 3. **입력 이미지 전처리**
- `DrawActivity`에서 손글씨 이미지를 `Bitmap`으로 변환
- `28x28x1` 크기로 이미지 변환 (MNIST 데이터셋 포맷에 맞춤)
- `ByteBuffer` 변환을 통해 TensorFlow Lite 모델 입력으로 전달

#### 4. **추론 및 결과 해석**
- `interpreter.run(input, result)`을 사용하여 모델 실행
- 출력값을 기반으로 가장 높은 확률을 가진 숫자 분류 결과 도출
- `argmax()` 함수를 사용하여 최종 결과 해석 및 출력

#### 5. **DrawActivity UI 구성**
- 손글씨 입력을 받을 `DrawView` 구현
- `CLASSIFY`, `CLEAR` 버튼 추가 및 동작 설정
- 모델 결과를 표시하는 `TextView` 추가

---


## 🔧 사용된 기술
- **언어**: Kotlin
- **TensorFlow Lite**
  - `TFLiteConverter` → 텐서플로 모델을 `.tflite`로 변환
  - `Interpreter` → 변환된 모델을 Android 앱에서 실행
  - `ByteBuffer` → 모델 입력을 위한 데이터 변환
- **이미지 처리**
  - `Bitmap.createScaledBitmap()` → 입력 이미지 크기 조정
  - `Canvas.drawBitmap()` → DrawActivity에서 손글씨 입력
- **파일 및 데이터 관리**
  - `MappedByteBuffer` → 모델 파일을 메모리에 로드
  - `assets` 폴더에서 `.tflite` 모델 불러오기
- **UI 구성**
  - `DrawActivity` → 손글씨 입력 및 변환
  - `TextView`, `Button` 등을 활용한 결과 출력

