<template>
    <div>
        <!-- namefield의 값은 참조하는 어그리거트의 속성값중 하나로 변경하면 변경한 속성에 맞는 필드명이 표시됩니다.  ex)nameField="속성값" <span>{{ value && value.속성값 ? value.속성값 : '' }}</span> -->
        <div v-if="Array.isArray(value)">
            <div v-for="(item, index) in value" :key="index">
                <span>{{ item.name ? item.name : '' }}</span>
            </div>
        </div>
        <div v-else>
            <BasePicker v-if="editMode" searchApiPath="housingprojects" searchParameterName="name"  idField="id" nameField="name" path="housingprojects" label="HousingProjectId" v-model="value" @selected="pick" :editMode="editMode" />
            <div v-else style="height:100%">
                <span>{{ value && value.name ? value.name : '' }}</span>
            </div>
        </div>
    </div>

</template>

<script>
import BaseEntity from './base-ui/BaseEntity.vue'
import BasePicker from './base-ui/BasePicker.vue'

export default {
    name: 'HousingProjectId',
    mixins:[BaseEntity],
    components:{
        BasePicker
    },
    data: () => ({
        path: 'housingprojects',
    }),
    props: {
    },
    watch: {
        value(val){
            this.value = val;
            this.change();
        },
    },
    async created() {
        if (Array.isArray(this.modelValue)) {
            this.value = await Promise.all(this.modelValue.map(async (item) => {
                if (item && item.id !== undefined) {
                    return await this.repository.findById(item.id);
                }
                return item;
            }));
        } else {
            this.value = this.modelValue;
            if (this.value && this.value.id !== undefined) {
                this.value = await this.repository.findById(this.value.id);
            }
        }
    },
    methods: {
        pick(val){
            this.value = val;
            this.change();
        },
    }
}
</script>

