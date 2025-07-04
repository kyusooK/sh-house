<template>
    <div>
        <String
            label="모집공고명"
            v-model="value.title"
            :editMode="editMode"
        />
        <String
            label="모집공고내용"
            v-model="value.content"
            :editMode="editMode"
        />
        <String
            label="대상단지명"
            v-model="value.houseName"
            :editMode="editMode"
        />
        <String
            label="대상단지위치"
            v-model="value.houseLocation"
            :editMode="editMode"
        />
        <Date
            label="신청시작일자"
            v-model="value.applyStartDate"
            :editMode="editMode"
        />
        <Date
            label="신청종료일자"
            v-model="value.applyEndDate"
            :editMode="editMode"
        />
        <Date
            label="입주시작일자"
            v-model="value.moveInStartDate"
            :editMode="editMode"
        />
        <Date
            label="입주종료일자"
            v-model="value.moveInEndDate"
            :editMode="editMode"
        />
        <String
            label="자격요건"
            v-model="value.eligibilityCriteria"
            :editMode="editMode"
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
    name: 'Announcement',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "announcements",
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
