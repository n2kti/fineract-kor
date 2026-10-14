# [CLS] API명세서

> 화면 1개 롤업(소분류 CLS, 대분류 CL - 일괄 수납 집계표).

## CLS-001 일괄 수납 집계표

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/collectionsheet/api/CollectionSheetApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `POST` | `/v1/collectionsheet` | `CollectionSheetApiResource.generateCollectionSheet` |

### `POST /v1/collectionsheet` - CollectionSheetApiResource.generateCollectionSheet
- **설명**: `CollectionSheetApiResource`의 `generateCollectionSheet` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/collectionsheet/api/CollectionSheetApiResource.java`
