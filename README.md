# Clipit

## 기획배경 및 목표

```
운동 관련 숏폼을 많이 찾아보긴 하지만 본인들의 루틴을 정리하고 공유할 수 있는 서비스의 부재

=> 운동 루틴 포스팅 및 검색 + 커뮤니티
```

## Concept

<div align='center'>
    <img src="https://github.com/monghwadang/2024-CS-Study/assets/156163462/e3c75103-8ebe-470f-9b8a-d7db68cbed67">
</div>

### 운동 영상 클립의 `클립` + 클립으로 모아보기의 `클립`

## 개발 과정

### Tech Stack

<div align="center" style="max-width: 100%; display: flex; justify-content: center;">
    <figure style="margin: 0;">
        <img src="https://github.com/monghwadang/2024-CS-Study/assets/156163462/35848f00-64c7-46cb-b335-7481a582d33a" alt="Example Image" style="width: 100%; max-width: 500px; height: auto;">
        <figcaption style="margin-top: 10px; font-style: italic;"></figcaption>
    </figure>
</div>

### ERD & Class Diagram

<div align="center" style="display: flex; justify-content: space-between;">
    <img src="https://github.com/monghwadang/2024-CS-Study/assets/156163462/c5a922fa-bd76-44c5-aed0-4ec15b17e26f" alt="ERD" style="width: 48%; max-width: 400px;">
    <img src="https://github.com/monghwadang/2024-CS-Study/assets/156163462/c3c475ba-63c1-4c18-a358-82c3bb45f3b4" alt="Class Diagram" style="width: 48%; max-width: 400px;">
</div>

## 화면 상세

| **Main Page** |
| :-: |
| ![Main Page](https://github.com/monghwadang/2024-CS-Study/assets/156163462/4850170c-e65e-4e9c-bc09-224a2878e4c5) <br> 

| **Routine Detail** |
| :-: |
| ![Routine Detail](https://github.com/monghwadang/2024-CS-Study/assets/156163462/a2e0214d-8cdb-42ae-a973-5f13fc4ef005) <br> 

| **New Routine** | **New Routine Modal** |
| :-: | :-: |
| ![New Routine](https://github.com/monghwadang/2024-CS-Study/assets/156163462/ba6772eb-9a91-499b-82d7-7dbefc05f410) <br> *신규 루틴 등록 화면* | ![New Routine Modal](https://github.com/monghwadang/2024-CS-Study/assets/156163462/f1599619-7872-47f1-b751-2d2cc00ed538) <br> *영상 등록 모달 및 추가 정보 입력* |

| **Search** | **Search Results** |
| :-: | :-: |
| ![Search](https://github.com/monghwadang/2024-CS-Study/assets/156163462/c79fe130-f209-4ac9-b9fc-0adb48ece50a) <br> *검색 화면* | ![Search Results](https://github.com/monghwadang/2024-CS-Study/assets/156163462/01e8ab59-e56d-4d52-908a-7391c45123dd) <br> *검색 결과* |

| **My Page** | **My Page Statistics** |
| :-: | :-: |
| ![My Page](https://github.com/monghwadang/2024-CS-Study/assets/156163462/d81151ef-5ccf-44d4-88e0-fb1a025ba4f5) <br> *전체 화면 및 나의 태그 입력* | ![My Page Statistics](https://github.com/monghwadang/2024-CS-Study/assets/156163462/e29c44cc-23f2-4c4f-ba3a-3e4aa4257dfe) <br> *활동성 statistics 및 최근 열람 루틴* |

| **My Routine** | **My Routine Filtered** |
| :-: | :-: |
| ![My Routine](https://github.com/monghwadang/2024-CS-Study/assets/156163462/7014844b-4dbd-4f6e-a87f-d037da80ac7a) <br> *나의 전체 루틴* | ![My Routine Filtered](https://github.com/monghwadang/2024-CS-Study/assets/156163462/68c962b0-4553-4f38-8e2e-f18273608027) <br> *내가 등록 / 내가 찜한 루틴 필터* |

## 성능 비교

### 데이터가 많아질수록 검색 성능은 더욱 좋아짐

<div align="center" style="max-width: 50%; display: flex; justify-content: center; margin: 0 auto;"> 
    <figure style="margin: 0;"> 
        <img src="https://github.com/monghwadang/2024-CS-Study/assets/156163462/e198720c-f27c-4576-be6e-5cf69dff6741" alt="Performance Comparison" style="width: 50% height: auto;"> 
    </figure> 
</div>

## 기대 효과

### ✅ Elasticsearch를 통한 검색 최적화로 사용자 경험 극대화

### ✅ 마이페이지 내 활동성 관련 시각화 statistics 제공으로 운동 습관 개선 및 리텐션 증대

## Review

<table style="width: 100%;">
    <thead>
        <tr>
            <th>KEEP</th>
            <th>PROBLEM</th>
            <th>TRY</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>
                <strong>객체 지향을 위한 노력</strong><br>
                - 컴포넌트 재사용<br>
                - 코드 재사용
            </td>
            <td>
                <strong>데이터 관리(기획->개발)</strong><br>
                - 데이터 정리 업데이트<br>
                <strong>코드 리뷰</strong>
            </td>
            <td>
                <strong>Exception</strong><br>
                <strong>ELK Stack 완성</strong><br>
                <strong>Docker</strong>
            </td>
        </tr>
    </tbody>
</table>

## 구성원

### 🐺 김명화 [@monghwadang](http://github.com/monghwadang)

### 🐱 박혜원 [@hyewon-p](http://github.com/hyewon-p)
