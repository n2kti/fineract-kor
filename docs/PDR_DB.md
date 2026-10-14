# [PDR] DB명세서

> 화면 1개 롤업(소분류 PDR, 대분류 PD - 금리·수수료·세무 설정).

## PDR-001 금리·수수료·세무 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/rate/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_rate` | 기준금리 및 수수료율 마스터 |
| `m_floating_rates` | 시장 기준금리(CD금리, 코픽스 등) 변동금리 엔티티 |
| `m_floating_rates_periods` | 변동금리의 기간별 적용 금리값 이력 |
| `m_interest_rate_chart` | 수신/여신 금리 차트 정의 (효력시작일자, 차트명) |
| `m_interest_rate_slab` | 금리 차트 내 기간/금액 구간별 이자율 슬랩 |
| `m_charge` | 수수료 마스터 (정액, 정률, 징수시점, 계산방법 등 25개 컬럼) |
| `m_tax_group` | 원천징수 세무 그룹 (이자소득세+지방소득세 묶음) |
| `m_tax_component` | 개별 세금 구성요소 (세율, 회계계정 매핑) |
| `m_tax_group_mappings` | 세무 그룹과 세금 구성요소 간 매핑 |

### `m_rate` - 기준금리 및 수수료율 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(250) | NOT NULL | 명칭 / 이름 |
| `percentage` | DECIMAL(10, 2) | NOT NULL | percentage 이자율/비율 |
| `active` | boolean | NULL | active 필드 |
| `product_apply` | SMALLINT | NOT NULL | product_apply 필드 |
| `created_date` | datetime | NULL | 생성 일시 |
| `createdby_id` | BIGINT | NOT NULL | 생성자 ID |
| `lastmodifiedby_id` | BIGINT | NOT NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `approve_user` | BIGINT | NULL | approve_user 필드 |

### `m_floating_rates` - 시장 기준금리(CD금리, 코픽스 등) 변동금리 엔티티
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `name` | VARCHAR(200) | NOT NULL | 명칭 / 이름 |
| `is_base_lending_rate` | boolean | NOT NULL | base_lending_rate 여부 플래그 (Boolean) |
| `is_active` | boolean | NOT NULL | 활성화 여부 |
| `createdby_id` | BIGINT | NOT NULL | 생성자 ID |
| `created_date` | datetime | NOT NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NOT NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NOT NULL | 최종 수정 일시 |

### `m_floating_rates_periods` - 변동금리의 기간별 적용 금리값 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `floating_rates_id` | BIGINT | NOT NULL | floating_rates 참조 식별자 (FK) |
| `from_date` | datetime | NOT NULL | from_date 일자 |
| `interest_rate` | DECIMAL(19, 6) | NOT NULL | interest_rate 이자율/비율 |
| `is_differential_to_base_lending_rate` | boolean | NOT NULL | differential_to_base_lending_rate 여부 플래그 (Boolean) |
| `is_active` | boolean | NOT NULL | 활성화 여부 |
| `createdby_id` | BIGINT | NOT NULL | 생성자 ID |
| `created_date` | datetime | NOT NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NOT NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NOT NULL | 최종 수정 일시 |

### `m_interest_rate_chart` - 수신/여신 금리 차트 정의 (효력시작일자, 차트명)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NULL | 명칭 / 이름 |
| `description` | VARCHAR(200) | NULL | description 필드 |
| `from_date` | date | NOT NULL | from_date 일자 |
| `end_date` | date | NULL | end_date 일자 |
| `is_primary_grouping_by_amount` | boolean | NOT NULL | primary_grouping_by_amount 여부 플래그 (Boolean) |

### `m_interest_rate_slab` - 금리 차트 내 기간/금액 구간별 이자율 슬랩
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `interest_rate_chart_id` | BIGINT | NOT NULL | interest_rate_chart 참조 식별자 (FK) |
| `description` | VARCHAR(200) | NULL | description 필드 |
| `period_type_enum` | SMALLINT | NULL | period_type 유형 구분 Enum 코드 |
| `from_period` | INT | NULL | from_period 필드 |
| `to_period` | INT | NULL | to_period 필드 |
| `amount_range_from` | DECIMAL(19, 6) | NULL | amount_range_from 금액 |
| `amount_range_to` | DECIMAL(19, 6) | NULL | amount_range_to 금액 |
| `annual_interest_rate` | DECIMAL(19, 6) | NOT NULL | annual_interest_rate 이자율/비율 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |

### `m_charge` - 수수료 마스터 (정액, 정률, 징수시점, 계산방법 등 25개 컬럼)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NULL | 명칭 / 이름 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |
| `charge_applies_to_enum` | SMALLINT | NOT NULL | charge_applies_to 유형 구분 Enum 코드 |
| `charge_time_enum` | SMALLINT | NOT NULL | charge_time 유형 구분 Enum 코드 |
| `charge_calculation_enum` | SMALLINT | NOT NULL | charge_calculation 유형 구분 Enum 코드 |
| `charge_payment_mode_enum` | SMALLINT | NULL | charge_payment_mode 유형 구분 Enum 코드 |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `fee_on_day` | SMALLINT | NULL | fee_on_day 필드 |
| `fee_interval` | SMALLINT | NULL | fee_interval 필드 |
| `fee_on_month` | SMALLINT | NULL | fee_on_month 필드 |
| `is_penalty` | boolean | NOT NULL | penalty 여부 플래그 (Boolean) |
| `is_active` | boolean | NOT NULL | 활성화 여부 |
| `is_deleted` | boolean | NOT NULL | deleted 여부 플래그 (Boolean) |
| `min_cap` | DECIMAL(19, 6) | NULL | min_cap 필드 |
| `max_cap` | DECIMAL(19, 6) | NULL | max_cap 필드 |
| `fee_frequency` | SMALLINT | NULL | fee_frequency 필드 |
| `is_free_withdrawal` | boolean | NOT NULL | free_withdrawal 여부 플래그 (Boolean) |
| `free_withdrawal_charge_frequency` | INT | NULL | free_withdrawal_charge_frequency 필드 |
| `restart_frequency` | INT | NULL | restart_frequency 필드 |
| `restart_frequency_enum` | INT | NULL | restart_frequency 유형 구분 Enum 코드 |
| `is_payment_type` | boolean | NULL | payment_type 여부 플래그 (Boolean) |
| `payment_type_id` | INT | NULL | payment_type 참조 식별자 (FK) |
| `income_or_liability_account_id` | BIGINT | NULL | income_or_liability_account 참조 식별자 (FK) |
| `tax_group_id` | BIGINT | NULL | tax_group 참조 식별자 (FK) |

### `m_tax_group` - 원천징수 세무 그룹 (이자소득세+지방소득세 묶음)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(50) | NOT NULL | 명칭 / 이름 |
| `createdby_id` | BIGINT | NOT NULL | 생성자 ID |
| `created_date` | datetime | NOT NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NOT NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NOT NULL | 최종 수정 일시 |

### `m_tax_component` - 개별 세금 구성요소 (세율, 회계계정 매핑)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(50) | NOT NULL | 명칭 / 이름 |
| `percentage` | DECIMAL(19, 6) | NOT NULL | percentage 이자율/비율 |
| `debit_account_type_enum` | SMALLINT | NULL | debit_account_type 유형 구분 Enum 코드 |
| `debit_account_id` | BIGINT | NULL | debit_account 참조 식별자 (FK) |
| `credit_account_type_enum` | SMALLINT | NULL | credit_account_type 유형 구분 Enum 코드 |
| `credit_account_id` | BIGINT | NULL | credit_account 참조 식별자 (FK) |
| `start_date` | date | NOT NULL | start_date 일자 |
| `createdby_id` | BIGINT | NOT NULL | 생성자 ID |
| `created_date` | datetime | NOT NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NOT NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NOT NULL | 최종 수정 일시 |

### `m_tax_group_mappings` - 세무 그룹과 세금 구성요소 간 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `tax_group_id` | BIGINT | NOT NULL | tax_group 참조 식별자 (FK) |
| `tax_component_id` | BIGINT | NOT NULL | tax_component 참조 식별자 (FK) |
| `start_date` | date | NOT NULL | start_date 일자 |
| `end_date` | date | NULL | end_date 일자 |
| `createdby_id` | BIGINT | NOT NULL | 생성자 ID |
| `created_date` | datetime | NOT NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NOT NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NOT NULL | 최종 수정 일시 |

## 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0024_add_audit_entries.xml`
