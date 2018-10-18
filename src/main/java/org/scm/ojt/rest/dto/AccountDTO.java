package org.scm.ojt.rest.dto;

import lombok.*;

/**
 * Created by Yoyok_T on 17/10/2018.
 */
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class AccountDTO extends BaseDTO {
    private String name;

}
