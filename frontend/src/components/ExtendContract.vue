<template>
    <div>
        <String
            label="연장계약서류"
            v-model="value.document"
            :editMode="editMode"
        />
        <Date
            label="입주연장일자"
            v-model="value.extendEndAt"
            :editMode="editMode"
        />
        <Boolean
            label="연장검증결과"
            v-model="value.isExtend"
            :editMode="editMode"
        />
        <ContractId
            offline
            label="계약정보"
            v-model="value.contractId"
            :editMode="editMode"
            @change="change"
        />
        <TenantId
            offline
            label="입주정보"
            v-model="value.tenantId"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'ExtendContract',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "extendContracts",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
