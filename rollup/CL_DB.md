# [CL] DB명세서 (고객관리)

> 소분류 3개 롤업.


---

## [CLA] DB명세서

> 화면 2개 롤업(소분류 CLA, 대분류 CL - 고객 관리).

### CLA-001 고객 목록 및 검색

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_client` | 고객 기본 인적사항, 계좌 식별정보 및 생애주기 상태 관리 |
| `m_client_identifier` | 고객 신분증(주민등록증, 여권, 사업자등록증 등) KYC 식별자 |
| `m_client_non_person` | 법인/단체 고객의 사업자등록번호, 대표자명, 설립일 등 법인 상세정보 |

#### `m_client` - 고객 기본 인적사항, 계좌 식별정보 및 생애주기 상태 관리
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `created_by` | BIGINT | NULL | created_by 필드 |
| `last_modified_by` | BIGINT | NULL | last_modified_by 필드 |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `account_no` | VARCHAR(20) | NOT NULL | 계좌 번호 |
| `external_id` | VARCHAR(100) | NULL | 외부 식별자 (UUID 등) |
| `status_enum` | INT | NOT NULL | 상태 코드 Enum |
| `sub_status` | INT | NULL | sub_status 필드 |
| `activation_date` | date | NULL | 활성화 일자 |
| `office_joining_date` | date | NULL | office_joining_date 일자 |
| `office_id` | BIGINT | NOT NULL | 지점 ID (FK: m_office.id) |
| `transfer_to_office_id` | BIGINT | NULL | transfer_to_office 참조 식별자 (FK) |
| `staff_id` | BIGINT | NULL | 담당 직원 ID (FK: m_staff.id) |
| `firstname` | VARCHAR(50) | NULL | 이름 (First Name) |
| `middlename` | VARCHAR(50) | NULL | 중간 이름 (Middle Name) |
| `lastname` | VARCHAR(50) | NULL | 성 (Last Name) |
| `fullname` | VARCHAR(100) | NULL | fullname 필드 |
| `display_name` | VARCHAR(100) | NOT NULL | 표시 명칭 |
| `mobile_no` | VARCHAR(50) | NULL | 휴대전화 번호 |
| `is_staff` | boolean | NOT NULL | staff 여부 플래그 (Boolean) |
| `gender_cv_id` | INT | NULL | 성별 코드값 ID (FK: m_code_value.id) |
| `date_of_birth` | date | NULL | 생년월일 |
| `image_id` | BIGINT | NULL | image 참조 식별자 (FK) |
| `closure_reason_cv_id` | INT | NULL | closure_reason_cv 참조 식별자 (FK) |
| `closedon_date` | date | NULL | 계좌 종결일자 |
| `updated_by` | BIGINT | NULL | updated_by 필드 |
| `updated_on` | date | NULL | updated_on 필드 |
| `submittedon_date` | date | NULL | 접수일자 |
| `submittedon_userid` | BIGINT | NULL | 접수자 ID |
| `activatedon_userid` | BIGINT | NULL | 활성화 승인자 ID |
| `closedon_userid` | BIGINT | NULL | 종결자 ID |
| `default_savings_product` | BIGINT | NULL | default_savings_product 필드 |
| `default_savings_account` | BIGINT | NULL | default_savings_account 필드 |
| `client_type_cv_id` | INT | NULL | 고객 유형 코드값 ID |
| `client_classification_cv_id` | INT | NULL | 고객 분류 코드값 ID |
| `reject_reason_cv_id` | INT | NULL | reject_reason_cv 참조 식별자 (FK) |
| `rejectedon_date` | date | NULL | rejectedon_date 일자 |
| `rejectedon_userid` | BIGINT | NULL | rejectedon_userid 필드 |
| `withdraw_reason_cv_id` | INT | NULL | withdraw_reason_cv 참조 식별자 (FK) |
| `withdrawn_on_date` | date | NULL | withdrawn_on_date 일자 |
| `withdraw_on_userid` | BIGINT | NULL | withdraw_on_userid 필드 |
| `reactivated_on_date` | date | NULL | reactivated_on_date 일자 |
| `reactivated_on_userid` | BIGINT | NULL | reactivated_on_userid 필드 |
| `legal_form_enum` | INT | NULL | legal_form 유형 구분 Enum 코드 |
| `reopened_on_date` | date | NULL | reopened_on_date 일자 |
| `reopened_by_userid` | BIGINT | NULL | reopened_by_userid 필드 |
| `email_address` | VARCHAR(150) | NULL | 이메일 주소 |
| `proposed_transfer_date` | date | NULL | proposed_transfer_date 일자 |
| `image_key` | varchar(500) | NULL | image_key 필드 |
| `joined_date` | date | NULL | joined_date 일자 |
| `is_deleted` | tinyint | NOT NULL | deleted 여부 플래그 (Boolean) |

#### `m_client_identifier` - 고객 신분증(주민등록증, 여권, 사업자등록증 등) KYC 식별자
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `client_id` | BIGINT | NOT NULL | 고객 ID (FK: m_client.id) |
| `document_type_id` | INT | NOT NULL | document_type 참조 식별자 (FK) |
| `document_key` | VARCHAR(50) | NOT NULL | document_key 필드 |
| `status` | INT | NOT NULL | status 필드 |
| `active` | INT | NULL | active 필드 |
| `description` | VARCHAR(500) | NULL | description 필드 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |

#### `m_client_non_person` - 법인/단체 고객의 사업자등록번호, 대표자명, 설립일 등 법인 상세정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `client_id` | BIGINT | NOT NULL | 고객 ID (FK: m_client.id) |
| `constitution_cv_id` | INT | NOT NULL | constitution_cv 참조 식별자 (FK) |
| `incorp_no` | VARCHAR(50) | NULL | incorp_no 필드 |
| `incorp_validity_till` | datetime | NULL | incorp_validity_till 필드 |
| `main_business_line_cv_id` | INT | NULL | main_business_line_cv 참조 식별자 (FK) |
| `remarks` | VARCHAR(150) | NULL | remarks 필드 |

### CLA-002 고객 등록 및 상세정보

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_family_members` | 고객의 가족/부양가족 구성원 정보 및 관계 |
| `m_client_address` | 고객과 주소 간 매핑 테이블 (자택, 직장 등 주소유형별) |
| `m_address` | 도로명주소, 지번, 우편번호, 위도/경도 등 주소 엔티티 |
| `m_client_charge` | 고객 단위 부과 수수료(회비, 발급수수료 등) |
| `m_client_transaction` | 고객 단위 수수료 납부 및 정산 거래 내역 |
| `m_client_collateral_management` | 고객 소유 담보물 관리 매핑 |

#### `m_family_members` - 고객의 가족/부양가족 구성원 정보 및 관계
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `client_id` | BIGINT | NOT NULL | 고객 ID (FK: m_client.id) |
| `firstname` | VARCHAR(50) | NOT NULL | 이름 (First Name) |
| `middlename` | VARCHAR(50) | NULL | 중간 이름 (Middle Name) |
| `lastname` | VARCHAR(50) | NULL | 성 (Last Name) |
| `qualification` | VARCHAR(50) | NULL | qualification 필드 |
| `relationship_cv_id` | INT | NOT NULL | relationship_cv 참조 식별자 (FK) |
| `marital_status_cv_id` | INT | NULL | marital_status_cv 참조 식별자 (FK) |
| `gender_cv_id` | INT | NULL | 성별 코드값 ID (FK: m_code_value.id) |
| `date_of_birth` | date | NULL | 생년월일 |
| `age` | INT | NULL | age 필드 |
| `profession_cv_id` | INT | NULL | profession_cv 참조 식별자 (FK) |
| `mobile_number` | VARCHAR(50) | NULL | mobile_number 필드 |
| `is_dependent` | boolean | NULL | dependent 여부 플래그 (Boolean) |

#### `m_client_address` - 고객과 주소 간 매핑 테이블 (자택, 직장 등 주소유형별)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `client_id` | BIGINT | NOT NULL | 고객 ID (FK: m_client.id) |
| `address_id` | BIGINT | NOT NULL | address 참조 식별자 (FK) |
| `address_type_id` | INT | NOT NULL | address_type 참조 식별자 (FK) |
| `is_active` | boolean | NOT NULL | 활성화 여부 |

#### `m_address` - 도로명주소, 지번, 우편번호, 위도/경도 등 주소 엔티티
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `street` | VARCHAR(100) | NULL | street 필드 |
| `address_line_1` | VARCHAR(100) | NULL | address_line_1 필드 |
| `address_line_2` | VARCHAR(100) | NULL | address_line_2 필드 |
| `address_line_3` | VARCHAR(100) | NULL | address_line_3 필드 |
| `town_village` | VARCHAR(100) | NULL | town_village 필드 |
| `city` | VARCHAR(100) | NULL | city 필드 |
| `county_district` | VARCHAR(100) | NULL | county_district 필드 |
| `state_province_id` | INT | NULL | state_province 참조 식별자 (FK) |
| `country_id` | INT | NULL | country 참조 식별자 (FK) |
| `postal_code` | VARCHAR(10) | NULL | postal_code 필드 |
| `latitude` | DECIMAL(10, 8) | NULL | latitude 필드 |
| `longitude` | DECIMAL(10, 8) | NULL | longitude 필드 |
| `created_by` | VARCHAR(100) | NULL | created_by 필드 |
| `created_on` | date | NULL | created_on 필드 |
| `updated_by` | VARCHAR(100) | NULL | updated_by 필드 |
| `updated_on` | date | NULL | updated_on 필드 |

#### `m_client_charge` - 고객 단위 부과 수수료(회비, 발급수수료 등)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `client_id` | BIGINT | NOT NULL | 고객 ID (FK: m_client.id) |
| `charge_id` | BIGINT | NOT NULL | charge 참조 식별자 (FK) |
| `is_penalty` | boolean | NOT NULL | penalty 여부 플래그 (Boolean) |
| `charge_time_enum` | SMALLINT | NOT NULL | charge_time 유형 구분 Enum 코드 |
| `charge_due_date` | date | NULL | charge_due_date 일자 |
| `charge_calculation_enum` | SMALLINT | NOT NULL | charge_calculation 유형 구분 Enum 코드 |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `amount_paid_derived` | DECIMAL(19, 6) | NULL | amount_paid 자동 집계/산출 필드 |
| `amount_waived_derived` | DECIMAL(19, 6) | NULL | amount_waived 자동 집계/산출 필드 |
| `amount_writtenoff_derived` | DECIMAL(19, 6) | NULL | amount_writtenoff 자동 집계/산출 필드 |
| `amount_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | amount_outstanding 자동 집계/산출 필드 |
| `is_paid_derived` | boolean | NULL | is_paid 자동 집계/산출 필드 |
| `waived` | boolean | NULL | waived 필드 |
| `is_active` | boolean | NULL | 활성화 여부 |
| `inactivated_on_date` | date | NULL | inactivated_on_date 일자 |

#### `m_client_transaction` - 고객 단위 수수료 납부 및 정산 거래 내역
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `created_by` | BIGINT | NULL | created_by 필드 |
| `last_modified_by` | BIGINT | NULL | last_modified_by 필드 |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `submitted_on_date` | DATE | NOT NULL | submitted_on_date 일자 |
| `client_id` | BIGINT | NOT NULL | 고객 ID (FK: m_client.id) |
| `office_id` | BIGINT | NOT NULL | 지점 ID (FK: m_office.id) |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |
| `payment_detail_id` | BIGINT | NULL | payment_detail 참조 식별자 (FK) |
| `is_reversed` | boolean | NOT NULL | reversed 여부 플래그 (Boolean) |
| `external_id` | VARCHAR(50) | NULL | 외부 식별자 (UUID 등) |
| `transaction_date` | date | NOT NULL | transaction_date 일자 |
| `transaction_type_enum` | SMALLINT | NOT NULL | transaction_type 유형 구분 Enum 코드 |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `created_date` | datetime | NOT NULL | 생성 일시 |
| `appuser_id` | BIGINT | NOT NULL | appuser 참조 식별자 (FK) |

#### `m_client_collateral_management` - 고객 소유 담보물 관리 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `quantity` | DECIMAL(20, 5) | NOT NULL | quantity 필드 |
| `client_id` | BIGINT | NULL | 고객 ID (FK: m_client.id) |
| `collateral_id` | BIGINT | NULL | collateral 참조 식별자 (FK) |

### 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/address/domain/Address.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/domain/ClientAddress.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/domain/ClientCharge.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/domain/ClientFamilyMembers.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/domain/ClientNonPerson.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0020_add_audit_entries.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0024_add_audit_entries.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0031_add_audit_entries_to_client_identifier.xml`

---

## [CLG] DB명세서

> 화면 1개 롤업(소분류 CLG, 대분류 CL - 그룹 및 센터 관리).

### CLG-001 그룹 및 센터 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/group/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_group` | 소액금융 그룹(Group) 및 상위 센터(Center) 기본 정보 |
| `m_group_client` | 그룹과 소속 고객(구성원) 간 N:M 매핑 |
| `m_group_roles` | 그룹 내 직책(그룹장, 총무 등) 지정 정보 |
| `m_group_level` | 조직/그룹 계층 레벨 정의 |
| `m_meeting` | 그룹/센터의 정기 모임(Center Meeting) 실행 기록 |
| `m_calendar` | 정기 모임 일정 캘린더 정의(반복주기, 요일) |
| `m_calendar_instance` | 특정 그룹/센터 엔티티에 연계된 캘린더 인스턴스 |

#### `m_group` - 소액금융 그룹(Group) 및 상위 센터(Center) 기본 정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `external_id` | VARCHAR(100) | NULL | 외부 식별자 (UUID 등) |
| `status_enum` | INT | NOT NULL | 상태 코드 Enum |
| `activation_date` | date | NULL | 활성화 일자 |
| `office_id` | BIGINT | NOT NULL | 지점 ID (FK: m_office.id) |
| `staff_id` | BIGINT | NULL | 담당 직원 ID (FK: m_staff.id) |
| `parent_id` | BIGINT | NULL | parent 참조 식별자 (FK) |
| `level_id` | INT | NOT NULL | level 참조 식별자 (FK) |
| `display_name` | VARCHAR(100) | NOT NULL | 표시 명칭 |
| `hierarchy` | VARCHAR(100) | NULL | hierarchy 필드 |
| `closure_reason_cv_id` | INT | NULL | closure_reason_cv 참조 식별자 (FK) |
| `closedon_date` | date | NULL | 계좌 종결일자 |
| `activatedon_userid` | BIGINT | NULL | 활성화 승인자 ID |
| `submittedon_date` | date | NULL | 접수일자 |
| `submittedon_userid` | BIGINT | NULL | 접수자 ID |
| `closedon_userid` | BIGINT | NULL | 종결자 ID |
| `account_no` | VARCHAR(20) | NOT NULL | 계좌 번호 |
| `name` | varchar(100) | NOT NULL | 명칭 / 이름 |
| `is_deleted` | tinyint | NOT NULL | deleted 여부 플래그 (Boolean) |

#### `m_group_client` - 그룹과 소속 고객(구성원) 간 N:M 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `group_id` | BIGINT | PK, NOT NULL | 그룹 ID (FK: m_group.id) |
| `client_id` | BIGINT | PK, NOT NULL | 고객 ID (FK: m_client.id) |

#### `m_group_roles` - 그룹 내 직책(그룹장, 총무 등) 지정 정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `client_id` | BIGINT | NULL | 고객 ID (FK: m_client.id) |
| `group_id` | BIGINT | NULL | 그룹 ID (FK: m_group.id) |
| `role_cv_id` | INT | NULL | role_cv 참조 식별자 (FK) |

#### `m_group_level` - 조직/그룹 계층 레벨 정의
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | INT | PK, NOT NULL | 고유 식별자 (PK) |
| `parent_id` | INT | NULL | parent 참조 식별자 (FK) |
| `super_parent` | boolean | NOT NULL | super_parent 필드 |
| `level_name` | VARCHAR(100) | NOT NULL | level_name 필드 |
| `recursable` | boolean | NOT NULL | recursable 필드 |
| `can_have_clients` | boolean | NOT NULL | can_have_clients 필드 |
| `INDEX` | `Parent_levelId_reference` | NULL | INDEX 필드 |

#### `m_meeting` - 그룹/센터의 정기 모임(Center Meeting) 실행 기록
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `calendar_instance_id` | BIGINT | NOT NULL | calendar_instance 참조 식별자 (FK) |
| `meeting_date` | date | NOT NULL | meeting_date 일자 |

#### `m_calendar` - 정기 모임 일정 캘린더 정의(반복주기, 요일)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `title` | VARCHAR(70) | NOT NULL | title 필드 |
| `description` | VARCHAR(100) | NULL | description 필드 |
| `location` | VARCHAR(50) | NULL | location 필드 |
| `start_date` | date | NOT NULL | start_date 일자 |
| `end_date` | date | NULL | end_date 일자 |
| `duration` | SMALLINT | NULL | duration 필드 |
| `calendar_type_enum` | SMALLINT | NOT NULL | calendar_type 유형 구분 Enum 코드 |
| `repeating` | boolean | NOT NULL | repeating 필드 |
| `recurrence` | VARCHAR(100) | NULL | recurrence 필드 |
| `remind_by_enum` | SMALLINT | NULL | remind_by 유형 구분 Enum 코드 |
| `first_reminder` | SMALLINT | NULL | first_reminder 필드 |
| `second_reminder` | SMALLINT | NULL | second_reminder 필드 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `meeting_time` | time | NULL | meeting_time 필드 |

#### `m_calendar_instance` - 특정 그룹/센터 엔티티에 연계된 캘린더 인스턴스
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `calendar_id` | BIGINT | NOT NULL | calendar 참조 식별자 (FK) |
| `entity_id` | BIGINT | NOT NULL | entity 참조 식별자 (FK) |
| `entity_type_enum` | SMALLINT | NOT NULL | entity_type 유형 구분 Enum 코드 |

### 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0035_add_audit_entries_to_calendar.xml`

---

## [CLS] DB명세서

> 화면 1개 롤업(소분류 CLS, 대분류 CL - 일괄 수납 집계표).

### CLS-001 일괄 수납 집계표

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/collectionsheet/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_client_attendance` | 정기 모임별 고객 출석 현황 기록 (출석, 결석, 대리출석 등) |
| `m_client_attendance` | 고객별 모임 출석 이력 집계 |
| `m_meeting` | 모임 일자 및 수납 회차 정보 |

#### `m_client_attendance` - 정기 모임별 고객 출석 현황 기록 (출석, 결석, 대리출석 등)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 |
| `name` | VARCHAR(100) | NOT NULL | 엔티티 명칭 |
| `created_date` | DATETIME | NULL | 생성 일시 |

#### `m_client_attendance` - 고객별 모임 출석 이력 집계
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `client_id` | BIGINT | NOT NULL | 고객 ID (FK: m_client.id) |
| `meeting_id` | BIGINT | NOT NULL | meeting 참조 식별자 (FK) |
| `attendance_type_enum` | SMALLINT | NOT NULL | attendance_type 유형 구분 Enum 코드 |

#### `m_meeting` - 모임 일자 및 수납 회차 정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `calendar_instance_id` | BIGINT | NOT NULL | calendar_instance 참조 식별자 (FK) |
| `meeting_date` | date | NOT NULL | meeting_date 일자 |

### 근거
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
